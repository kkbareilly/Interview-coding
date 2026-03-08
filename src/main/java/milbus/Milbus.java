package milbus;

import io.milvus.client.MilvusServiceClient;
import io.milvus.grpc.DataType;
import io.milvus.grpc.ShowCollectionsResponse;
import io.milvus.param.ConnectParam;
import io.milvus.param.R;
import io.milvus.param.RpcStatus;
import io.milvus.param.collection.*;
import io.milvus.param.dml.InsertParam;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Milbus {

    public static void main(String[] args){
        final MilvusServiceClient milvusClient = new MilvusServiceClient(
                ConnectParam.newBuilder()
                        .withHost("localhost")
                        .withPort(19530)
                        .build()
        );
        CreateDatabaseParam param=  CreateDatabaseParam.newBuilder().withDatabaseName("search").build();
        milvusClient.createDatabase(param);

        System.out.println(milvusClient.checkHealth());
      System.out.println(milvusClient.listDatabases());
        R<RpcStatus> statusR=  milvusClient.createCollection(collectionDefinition());
    System.out.println(statusR.getStatus());
        R<Boolean> respHasCollection = milvusClient.hasCollection(
                HasCollectionParam.newBuilder()
                        .withCollectionName("book")
                        .build()
        );
        if (respHasCollection.getData() == Boolean.TRUE) {
            System.out.println("Collection exists.");
            insert(milvusClient);
          //  milvusClient.flush();
        }
        R<ShowCollectionsResponse> respShowCollections = milvusClient.showCollections(
                ShowCollectionsParam.newBuilder().build()
        );
        System.out.println(respShowCollections);
       // GetIdsParam id= GetIdsParam.newBuilder().withCollectionName("book").addPrimaryId().build();
       // R<GetResponse> read= milvusClient.get(id);
   // System.out.println(read.getData());

    ;

    }


    private static CreateCollectionParam collectionDefinition(){
        FieldType fieldType1 = FieldType.newBuilder()
                .withName("book_id")
                .withDataType(DataType.Int64)
                .withPrimaryKey(true)
                .withAutoID(false)
                .build();
        FieldType fieldType2 = FieldType.newBuilder()
                .withName("word_count")
                .withDataType(DataType.Int64)
                .build();
        FieldType fieldType3 = FieldType.newBuilder()
                .withName("book_intro")
                .withDataType(DataType.FloatVector)
                .withDimension(2)
                .build();
        CreateCollectionParam createCollectionReq = CreateCollectionParam.newBuilder()
                .withCollectionName("book")
                //.withDatabaseName("search")
                .withDescription("Test book search")
                .withShardsNum(2)
               // .withPartitionsNum(2)
                .addFieldType(fieldType1)
                .addFieldType(fieldType2)
                .addFieldType(fieldType3)
                .withEnableDynamicField(true)
                .build();
        return createCollectionReq;
    }

  private static void insert(MilvusServiceClient milvusClient) {
    Random ran = new Random();
    List<Long> book_id_array = new ArrayList<>();
    List<Long> word_count_array = new ArrayList<>();
    List<List<Float>> book_intro_array = new ArrayList<>();
    for (long i = 0L; i < 2000; ++i) {
      book_id_array.add(i);
      word_count_array.add(i + 10000);
      List<Float> vector = new ArrayList<>();
      for (int k = 0; k < 2; ++k) {
        vector.add(ran.nextFloat());
      }
      book_intro_array.add(vector);
    }


      List<InsertParam.Field> fields = new ArrayList<>();
      fields.add(new InsertParam.Field("book_id", book_id_array));
      fields.add(new InsertParam.Field("word_count", word_count_array));
      fields.add(new InsertParam.Field("book_intro", book_intro_array));

      InsertParam insertParam = InsertParam.newBuilder()
              .withCollectionName("book")
              .withPartitionName("novel")
              .withFields(fields)
              .build();
      milvusClient.insert(insertParam);
        }
}

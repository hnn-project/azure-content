#Java에서 Blob 저장소를 사용하는 방법
이 문서에서는 Azure Blob 저장소를 사용하여 일반 시나리오를 수행하는 방법을 보여 줍니다
샘플은 Java로 작성되었으며 Java용 Azure Storage SDK(영문)를 사용합니다.
여기서 다루는 시나리오에는 컨테이너 생성, Blob 업로드, Blob 나열이 포함됩니다.
 - 샘플소스: azure-content/demo/storage-demo/storage-demo-java/src/main/java/kr/co/ds_etrade/storage_demo/

## 1. 컨테이너 만들기
CloudBlobClient 개체를 사용하면 컨테이너 및 Blob에 대한 참조 개체를 가져올 수 있습니다.
 - server_blob_container_create_41.java

## 2. 컨테이너에 Blob 업로드
Blob에 파일을 업로드하려면 컨테이너 참조를 가져온 후 이 참조를 사용하여 Blob 참조를 가져옵니다.
Blob 참조가 있으면 Blob 참조의 upload를 호출하여 스트림을 업로드할 수 있습니다.
이 작업은 Blob이 없는 경우 새로 만들고, Blob이 있는 경우 덮어씁니다.
 - server_blob_container_upload_42.java

## 3. 컨테이너의 Blob 나열
컨테이너의 Blob을 나열하려면 Blob을 업로드할 때 수행한 것과 마찬가지로 컨테이너 참조를 가져옵니다.
for 루프와 함께 컨테이너의 listBlobs 메서드를 사용할 수 있습니다. 다음 코드는 컨테이너에 있는 각 Blob의 Uri를 콘솔에 출력합니다.
 - server_blob_container_list_43.java

#Java에서 테이블 저장소를 사용하는 방법
이 문서에서는 Azure 테이블 저장소 서비스를 사용하여 일반 시나리오를 수행하는 방법을 보여 줍니다.
샘플은 Java로 작성되었으며 Java용 Azure Storage SDK(영문)를 사용합니다.
여기에서 다루는 시나리오에는 테이블 생성과, 테이블에 엔터티 추가 및 엔터티 조회가 포함됩니다.
- 샘플소스: azure-content/demo/storage-demo/storage-demo-java/src/main/java/kr/co/ds_etrade/storage_demo/

## 1. 테이블 만들기
CloudTableClient 개체를 사용하면 테이블 및 엔터티에 대한 참조 개체를 가져올 수 있습니다.
 - server_table_create_31.java

## 2. 테이블에 엔터티 추가하기
엔터티는 TableEntity를 구현하는 사용자 지정 클래스를 사용하여 Java 개체에 매핑됩니다.
사용 편의를 위해 TableServiceEntity 클래스는 TableEntity를 구현하고, 리플렉션을 사용하여 속성에 맞춰 명명된 getter 및 setter 메서드에 속성을 매핑합니다.
테이블에 엔터티를 추가하려면 먼저 엔터티의 속성을 정의하는 클래스를 만듭니다.
엔터티의 파티션과 행 키가 결합되어 테이블에서 엔터티를 고유하게 식별합니다.
동일한 파티션 키를 가진 엔터티는 다른 파티션 키를 가진 엔터티보다 더 빨리 쿼리할 수 있습니다.
- server_insert_entity_32.java

## 1. 테이블의 엔터티 조회
TableQuery.generateFilterCondition 은 쿼리에 필요한 필터를 만들기 위한 도우미 메서드입니다.
쿼리에 필터를 적용하려면 TableQuery.from 메서드에 의해 반환된 참조에 대해 where를 호출합니다.
CloudTable 개체에 대해 execute를 호출하여 쿼리가 실행되면 쿼리는 CustomerEntity 결과 유형이 지정된 반복기를 반환합니다.
그러면 반환된 반복기 를 for each 루프에서 사용하여 결과를 이용할 수 있습니다.
 - server_table_get_entity_33.java

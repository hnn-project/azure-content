#Java에서 Blob 저장소를 사용하는 방법
샘플은 Java로 작성되었으며 Java용 Azure Storage SDK(영문)를 사용합니다.
여기서 다루는 시나리오에는 Blob 업로드, 나열, 다운로드 및 삭제가 포함됩니다.
샘플소스위치: azure-content/demo/storage-demo/storage-demo-java/src/main/java/kr/co/ds_etrade/storage_demo/

## 1. 컨테이너 만들기
CloudBlobClient 개체를 사용하면 컨테이너 및 Blob에 대한 참조 개체를 가져올 수 있습니다.
 - server_blob_container_create_41.java

## 2. 컨테이너에 Blob 업로드
Blob에 파일을 업로드하려면 컨테이너 참조를 가져온 후 이 참조를 사용하여 Blob 참조를 가져옵니다.
Blob 참조가 있으면 Blob 참조의 upload를 호출하여 스트림을 업로드할 수 있습니다. 이 작업은 Blob이 없는 경우 새로 만들고, Blob이 있는 경우 덮어씁니다.
 - server_blob_container_upload_42.java

## 3. 컨테이너의 Blob 나열
컨테이너의 Blob을 나열하려면 Blob을 업로드할 때 수행한 것과 마찬가지로 컨테이너 참조를 가져옵니다.
for 루프와 함께 컨테이너의 listBlobs 메서드를 사용할 수 있습니다. 다음 코드는 컨테이너에 있는 각 Blob의 Uri를 콘솔에 출력합니다.
 - server_blob_container_list_43.java

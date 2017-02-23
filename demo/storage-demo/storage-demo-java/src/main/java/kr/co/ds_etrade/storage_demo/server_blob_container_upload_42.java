package kr.co.ds_etrade.storage_demo;

import java.io.File;
import java.io.FileInputStream;

//Include the following imports to use blob APIs.
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

public class server_blob_container_upload_42 {

	// Define the connection-string with your values
	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;"
			+ "AccountName=<account_name>;"
			+ "AccountKey=<account_key>";

	public static void main(String[] args) throws Exception {

		try {
			// Retrieve storage account from connection-string.
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			// Create the blob client.
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

			// Retrieve reference to a previously created container.
			CloudBlobContainer container = blobClient.getContainerReference("nodecontainerjava");

			// Define the path to a local file.
			final String filePath = "C:\\azure_center_java.png";

			// Create or overwrite the "myimage.jpg" blob with contents from a
			// local file.
			CloudBlockBlob blob = container.getBlockBlobReference("azure_center_java.png");
			File source = new File(filePath);
			blob.upload(new FileInputStream(source), source.length());
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}

	}

}

package kr.co.ds_etrade.storage_demo;

//Include the following imports to use blob APIs.
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public class server_blob_container_create_41 {

	// Define the connection-string with your values
	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;"
			+ "AccountName=function0aa4a8eb8e79;"
			+ "AccountKey=gOGficJJTX9ehKDPp0b5YICDM/Jr23WJXyg44ZazqCW2xGlX0e+GSUwcX4MIrdKqFkGFFOTICWRgjLfGJsxt8w==";

	public static void main(String[] args) throws Exception {

		try {
			// Retrieve storage account from connection-string.
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			// Create the blob client.
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

			// Get a reference to a container.
			// The container name must be lower case
			CloudBlobContainer container = blobClient.getContainerReference("nodecontainerjava");

			// Create the container if it does not exist.
			container.createIfNotExists();
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}

	}

}

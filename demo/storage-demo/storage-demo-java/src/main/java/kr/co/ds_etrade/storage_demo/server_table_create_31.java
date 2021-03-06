package kr.co.ds_etrade.storage_demo;

//Include the following imports to use table APIs
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;
import com.microsoft.azure.storage.table.TableQuery.*;

public class server_table_create_31 {

	// Define the connection-string with your values
	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;"
			+ "AccountName=<account_name>;"
			+ "AccountKey=<account_key>";

	public static void main(String[] args) throws Exception {

		try
		{
		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create the table if it doesn't exist.
		    String tableName = "nodetable";
		    CloudTable cloudTable = tableClient.getTableReference(tableName);
		    cloudTable.createIfNotExists();
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}


	}

}

package kr.co.ds_etrade.storage_demo;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;

//Include the following imports to use table APIs


public class server_insert_entity_32 {

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

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("nodetable");

		    // Create a new customer entity.
		    TestEntity testEntity = new TestEntity("Harp", "Kemp");
		    testEntity.setDescription("First name and Last name");
		    testEntity.setDueDate("2017-02-27");

		    // Create an operation to add the new customer to the people table.
		    TableOperation insertTest1 = TableOperation.insertOrReplace(testEntity);

		    // Submit the operation to the table service.
		    cloudTable.execute(insertTest1);
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}


	}

}

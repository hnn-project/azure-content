package kr.co.ds_etrade.storage_demo;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;
import com.microsoft.azure.storage.table.TableQuery;
import com.microsoft.azure.storage.table.TableQuery.QueryComparisons;

//Include the following imports to use table APIs


public class server_table_get_entity_33 {

	// Define the connection-string with your values
	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;"
			+ "AccountName=<account_name>;"
			+ "AccountKey=<account_key>";

	public static void main(String[] args) throws Exception {

		try
		{
		    // Define constants for filters.
		    final String PARTITION_KEY = "PartitionKey";
		    final String ROW_KEY = "RowKey";
		    final String TIMESTAMP = "Timestamp";

		    // Retrieve storage account from connection-string.
		    CloudStorageAccount storageAccount =
		        CloudStorageAccount.parse(storageConnectionString);

		    // Create the table client.
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();

		    // Create a cloud table object for the table.
		    CloudTable cloudTable = tableClient.getTableReference("nodetable");

		    // Create a filter condition where the partition key is "Smith".
		    String partitionFilter = TableQuery.generateFilterCondition(
		        PARTITION_KEY,
		        QueryComparisons.EQUAL,
		        "Harp");

		    // Specify a partition query, using "Smith" as the partition key filter.
		    TableQuery<TestEntity> partitionQuery =
		        TableQuery.from(TestEntity.class)
		        .where(partitionFilter);

		    // Loop through the results, displaying information about the entity.
		    for (TestEntity entity : cloudTable.execute(partitionQuery)) {
		        System.out.println(entity.getPartitionKey() +
		            " " + entity.getRowKey() +
		            "\t" + entity.getDescription() +
		            "\t" + entity.getDueDate());
		    }
		}
		catch (Exception e)
		{
		    // Output the stack trace.
		    e.printStackTrace();
		}


	}

}

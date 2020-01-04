package steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.Assert;
import utils.DataTable;

import java.util.List;

public class TableSteps {

    @Step
    public void validateTable(DataTable dataTable, String tableName) {
        if ("search-filter".equals(tableName)) {
            searchFilterAssertion(dataTable);
        }
        if ("table-pagination".equals(tableName)){
            tablePaginationAssertion(dataTable);
        }
    }

    @Step
    private void tablePaginationAssertion(DataTable dataTable) {
        Assert.assertEquals(dataTable.getColumn("#").size(),13);
    }

    @Step
    private void searchFilterAssertion(DataTable dataTable) {
        List<String> indexList = dataTable.getColumn("#");
        Assert.assertThat(indexList, Matchers.contains("1234567".split("")));
        List<String> statusColumn = dataTable.getColumn("Status");
        Assert.assertThat(statusColumn, Matchers.everyItem(Matchers.isOneOf("in progress", "completed", "failed qa", "deployed")));
    }
}

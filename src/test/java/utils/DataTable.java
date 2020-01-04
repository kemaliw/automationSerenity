package utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataTable {
    private List<String> headers;
    private List<Map<String, String>> srcMap;

    public DataTable(String selector, UIInteractionSteps uiInteractionSteps) {
        WebElementFacade taskTable = uiInteractionSteps.$(By.cssSelector(selector));
        List<WebElementFacade> headers = taskTable.thenFindAll("tr th");
        List<WebElementFacade> rows = taskTable.thenFindAll("tbody tr");
        this.srcMap = new ArrayList<>();
        this.headers = webElementListToString(headers);
        rows.forEach(row -> {
            Map<String, String> tableRow = new LinkedHashMap<>();
            List<String> columns = webElementListToString(row.thenFindAll("td"));
            for (int i = 0; i < columns.size(); i++) {
                tableRow.put(this.headers.get(i), columns.get(i));
            }
            srcMap.add(tableRow);
        });
    }

    private List<String> webElementListToString(List<WebElementFacade> columns) {
        /*List<String> result = new ArrayList<>();
        columns.forEach(column->result.add(column.getText()));
        return result;*/
        return columns.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<String> getColumn(String key) {
        List<String> list = new ArrayList<>();
        for (Map<String, String> map : srcMap) {
            String s = map.get(key);
            list.add(s);
        }
        return list;
    }

    public List<String> getColumn2(String key) {
        return srcMap.stream().map(map -> map.get(key)).collect(Collectors.toList());
    }
}

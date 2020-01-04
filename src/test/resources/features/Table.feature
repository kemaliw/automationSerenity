Feature: I can read table data

  Scenario: User can read data from table
    Given User open page "https://www.seleniumeasy.com/test/table-search-filter-demo.html"
    Then User can read data using css "#task-table" with name "search-filter"

  Scenario: User can read data from table with pages (static page)
    Given User open page "https://www.seleniumeasy.com/test/table-pagination-demo.html"
    Then User can read data using css "table" with name "table-pagination"

# language: en
Feature:checking the presence of the main components on the main page

  Scenario: check settings button
    Then the user sees the settings button

  Scenario: check Benchmark Selector control
    Then the user sees Benchmark Selector control

  Scenario: check Application Toolbar with Summary, Grid & chart, Histogram, Scatter-plot and Reports tabs
    Then the user sees Application Toolbar with items

      | Summary      |
      | Grid & chart |
      | Histogram    |
      | Scatter-plot |
      | Reports      |

Feature: Task Management
  Scenario: Add a task and view it
    Given the application has started
    And the to-do list is empty
    When I add a task with title "Handle aftensmad" category "Dagligdag" and today's date
    And I show tasks
    Then I should see the task "Handle aftensmad" with category "Dagligdag" and today's date

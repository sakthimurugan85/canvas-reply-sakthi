@canvasReply
Feature:  Canvas Reply Test Scenarios
  As a canvas reply admin user
  I want to create contact, run report and remove events
  So that I can verify the system behaviour

  Background:
    Given user is logged in to crm cloud

  @create-contact
  Scenario: Create a new contact and verify the created contact details
    When the user navigates to the contacts page under sales and marketing
    And the user fills in the new contact form
    Then the user verifies the created contact details

  @run-report
  Scenario: Generate project profitability report and verify the results
    When the user navigates to the "project profitability" page
    And the user runs the project profitability report
    Then the user verifies some results are returned in the table

  @delete-activity-log
  Scenario: Remove events from activity log
    When the user navigates to the activity log page
    And the user deletes the first three items from the table
    Then the user verifies the items were deleted
Feature: Portal Test

Background: On DD Portal
    When navigate to dd portal

Scenario: Test Portal
    Given on dd portal
    Then login
    Then logout

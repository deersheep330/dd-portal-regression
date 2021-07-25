Feature: Portal Test

Background: On Declaration Status Tab
    When navigate to sep
    Then setup and navigate to declaration status tab

Scenario: Test Dashboard
    Given on declaration status tab
    When navigate to Dashboard
    Then click and validate Dashboard

Scenario: Test Declaration Pulse
    Given on declaration status tab
    When navigate to Declaration Pulse
    Then click and validate Declaration Pulse

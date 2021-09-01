Feature: Portal Test

    Background: On DD Portal
        When navigate to dd portal

    Scenario: Test First Company
        Given on dd portal
        Then click first company
        Then view report

    Scenario: Test First Ultimate Parent
        Given on dd portal
        Then click first ultimate parent
        Then view report

    Scenario: Test Last Company
        Given on dd portal
        Then click last company
        Then view report

    Scenario: Test Last Ultimate Parent
        Given on dd portal
        Then click last ultimate parent
        Then view report
        
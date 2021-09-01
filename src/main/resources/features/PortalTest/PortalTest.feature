Feature: Portal Test

    Background: On DD Portal
        When navigate to dd portal

    Scenario: Rank By Valid Patents
        Given on dd portal
        Then rank by valid patents

    Scenario: Rank By High Value Patents
        Given on dd portal
        Then rank by high value patents

    Scenario: Rank By Patents Filed
        Given on dd portal
        Then rank by patents filed

    Scenario: Rank By Patents
        Given on dd portal
        Then rank by patents

    Scenario: Test First Company
        Given on dd portal
        Then click first company
        Then view report

    Scenario: Test First Company All Fields
        Given on dd portal
        Then click first company
        Then view all fields report

    Scenario: Test First Ultimate Parent
        Given on dd portal
        Then click first ultimate parent
        Then view report

    Scenario: Test First Ultimate Parent All Fields
        Given on dd portal
        Then click first ultimate parent
        Then view all fields report

    Scenario: Test Last Company
        Given on dd portal
        Then click last company
        Then view report

    Scenario: Test Last Company All Fields
        Given on dd portal
        Then click last company
        Then view all fields report

    Scenario: Test Last Ultimate Parent
        Given on dd portal
        Then click last ultimate parent
        Then view report

    Scenario: Test Last Ultimate Parent All Fields
        Given on dd portal
        Then click last ultimate parent
        Then view all fields report

Feature: Change user adress after login

  Scenario: Change user delivery adress

    Given User is logged in to CodersLab account

    When User goes to UserAdressPage

    And User puts new delivery address

    And User saves information

    Then User sees "Address successfully added!"

    And User close window
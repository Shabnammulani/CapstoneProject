Feature: User Login

  Scenario Outline: Login with valid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And clicks on the Sign In link
    Then the user should be logged in successfully

    Examples:
      | username  | password  |
      | demouser | testingisfun99   |
      | image_not_loading_user | testingisfun99     |
      | existing_orders_user | testingisfun99     |
      | fav_user | testingisfun99     |


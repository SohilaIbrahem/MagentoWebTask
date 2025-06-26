@Scenario
  Feature: User Create new account:

    @SmokeTest
    Scenario: verify that user can create new account:
      Given User open website and Click on create new account
      When  Enter All required fields and click on Create Account
      Then  Account created successfully
Feature: Check vehicle existence

The covercheck insurance page enables user to verify the existence of a vehicle and 
displays the cover period if the vehicle does exist.
This feature file describes the behaviour of the vehicle search page:
https://covercheck.vwfsinsuranceportal.co.uk/

Background:
Given I load the covercheck insurance page


Scenario: Check for existing vehicle 
On the covercheck insurance page, the user is able to check if a vehicle exists
When I search by entering "OV12UYY"
Then the search should return "valid result"

Scenario: Check for non-existing vehicle
When I search by entering "KS24KYY"
Then the search should return "nothing"

Scenario: Check invalid vehicle registration number
When I search by entering ""
Then the search should return "an error message"



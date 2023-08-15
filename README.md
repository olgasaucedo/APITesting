# APITesting
This is my answer to the take home challenge.

The framework uses RestAssured and TestNG. 

I created a class for each domain of the API:
* PetTest
* StoreTest
* UserTest

The tests exercise each endpoint. They verify the response code. For relevant methods they also test the response body.

I created 2 suites under `resources`:
* A `regression` suite that contains all the tests.
* A `smoke` suite that contains a subset of all the tests. These represent the most important functionality.

# To run
1. Boot the `localhost` server containing the sample API.
2. Run `regression.xml` or `smoke.xml`.
3. Please remember to reboot the server before executing a suite.


package org.example.specification;

import io.cucumber.java.en.*;
import org.example.Main;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpecificationTest {

        private String output;

        @Given("the application has started")
        public void the_application_has_started() {
            // No-op: application will start in When step
        }

        @Given("the to-do list is empty")
        public void the_to_do_list_is_empty() {
            // No-op: starting state assumed empty
        }

        @When("I add a task with title {string} category {string} and today's date")
        public void i_add_a_task_with_title_category_and_today_s_date(String title, String category) throws Exception {
            String date = java.time.LocalDate.now().toString();
            output = tapSystemOutNormalized(() ->
                    withTextFromSystemIn(
                            "1", title, category, date,
                            "5", "6" // show tasks, then exit
                    ).execute(() -> Main.main(new String[0]))
            );
        }

        @When("I show tasks")
        public void i_show_tasks() {
            // Covered in above step (combined flow)
        }

        @Then("I should see the task {string} with category {string} and today's date")
        public void i_should_see_the_task_with_category_and_today_s_date(String title, String category) {
            assertTrue(output.contains(title));
            assertTrue(output.contains("Category: " + category));
            assertTrue(output.contains("Deadline: " + java.time.LocalDate.now()));
        }



}

package org.example.integration;
import org.example.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CLI Integration: Main + Scanner + ToDoList + Task")
class MainCliIntegrationTest {

    private static boolean containsTaskLine(String output,
                                            int index,
                                            String title,
                                            String category,
                                            String date,
                                            boolean completed) {

        List<String> lines = output.lines().toList();

        for (String raw : lines) {
            String l = raw; // don't trim; index might be mid-line
            boolean hasIndex = l.contains(index + ":");
            if (!hasIndex) continue;

            boolean hasTitle = l.contains(title);
            boolean hasCategory = l.contains("Category: " + category);
            boolean hasDeadline = l.contains("Deadline: " + date);

            // checkbox checks (tolerant to spaces)
            boolean hasChecked = l.contains("[ X ]");
            boolean hasUnchecked = l.matches(".*\\[\\s*\\].*") && !hasChecked;

            boolean boxOk = completed ? hasChecked : hasUnchecked;

            if (hasTitle && hasCategory && hasDeadline && boxOk) return true;
        }
        return false;
    }

    @Test
    @DisplayName("Add → Update(0) → Complete(0) → Show → Exit : updated values are shown and [ X ] is rendered")
    void add_update_complete_show_exit_test() throws Exception {
        String out = tapSystemOutNormalized(() ->
                withTextFromSystemIn(
                        // Add task
                        "1", "Old", "A", "2025-08-01",
                        // Update it
                        "2", "0", "New", "Work", "2025-09-01",
                        // Mark completed
                        "4", "0",
                        // Show then exit
                        "5", "6"
                ).execute(() -> Main.main(new String[0]))
        );

        assertTrue(
                containsTaskLine(out, 0, "New", "Work", "2025-09-01", true),
                "Expected updated, completed task printed at index 0.\nCaptured:\n---\n" + out + "\n---"
        );
    }

    @Test
    @DisplayName("Add two → Delete(0) → Show → Exit : first is removed and second reindexes to 0")
    void addtwo_delete_show_exit() throws Exception {
        String out = tapSystemOutNormalized(() ->
                withTextFromSystemIn(
                        "1", "A", "C1", "2025-01-01",     // add A
                        "1", "B", "C2", "2025-01-02",           // add B
                        "3", "0",                               // delete A (index 0)
                        "5", "6"                                // show, exit
                ).execute(() -> Main.main(new String[0]))
        );

        assertFalse(out.contains("A | Category: C1"),
                "Deleted task 'A' should not be printed.\nCaptured:\n---\n" + out + "\n---");

        assertTrue(
                containsTaskLine(out, 0, "B", "C2", "2025-01-02", false),
                "Expected 'B' at index 0 after deletion.\nCaptured:\n---\n" + out + "\n---"
        );
    }
}
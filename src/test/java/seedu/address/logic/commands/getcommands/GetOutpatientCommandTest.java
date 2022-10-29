package seedu.address.logic.commands.getcommands;

import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.PatientType;
import seedu.address.model.person.PatientTypePredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code GetOutpatientCommand}.
 */
public class GetOutpatientCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_filteredOutpatientList() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 4);
        PatientTypePredicate predicate = new PatientTypePredicate(PatientType.PatientTypes.OUTPATIENT);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(new GetOutpatientCommand(), model, expectedMessage, expectedModel);
    }
}

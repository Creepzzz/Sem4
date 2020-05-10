package se.kth.iv1350.amazingpos.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Takes care of the error messages for the user interface.
 */
public class ErrorMessageHandler {
    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();
    private final String NEW_LINE = "\n";
    private Date errorOccured;

    private ErrorMessageHandler(){}

    /**
     * Gets the singleton instance of <code>ErrorMessageHandler</code>
     * @return
     */
    public static ErrorMessageHandler getErrorMessageHandler(){
        return ERROR_MESSAGE_HANDLER;
    }

    /**
     * Prints out a message to the user interface.
     * The printout will have the date of the error and the message.
     * @param msg the message that will be printed out.
     */
    void showErrorMsg(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("*********************** ATTENTION CASHIER *********************************");
        builder.append(NEW_LINE);
        builder.append(getDateAndTimeOfError());
        builder.append(", ERROR MESSAGE: ");
        builder.append(msg);
        builder.append(NEW_LINE);
        builder.append("***************************************************************************");
        builder.append(NEW_LINE);
        System.out.println(builder.toString());
    }

    private String getDateAndTimeOfError(){
        errorOccured = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String error = dateFormat.format(errorOccured);
        return error;

    }
}
package ro.ccar.employeeservice.client;

public class OneLineLogger extends feign.Logger {

    @Override
    protected void log(String configKey, String format, Object... args) {
        // Format log message as a single line
        String message = String.format(configKey + " - " + format, args);
        System.out.println(message);
    }
}

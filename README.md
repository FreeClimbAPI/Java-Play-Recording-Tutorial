# Node - Play a Recording Tutorial

This project serves as a guide to help you build an application with Persephony. Specifically, the project will:

- Play a recording to a caller during a call.   

## Setting up your new app within your Persephony account

To get started using a persephony account, follow the instructions [here](https://persephony-docs.readme.io/docs/getting-started-with-persephony).

## Setting up the Tutorial

1. Install the node packages necessary using command:

   ```bash
   $ yarn install
   ```

2. Configure environment variables.

   | ENV VARIABLE            | DESCRIPTION                                                                                                                                                                             |
   | ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
   | ACCOUNT_ID              | Account ID which can be found under [API Keys](https://www.persephony.com/dashboard/portal/account/authentication) in Dashboard                                                         |
   | AUTH_TOKEN              | Authentication Token which can be found under [API Keys](https://www.persephony.com/dashboard/portal/account/authentication) in Dashboard                                               |
   | APPLICATION_ID | Appliction IDs can be found under [Apps](https://www.persephony.com/dashboard/portal/applications)

3. Provide a value for the variables `to`, `from`, and `recordingUrl` in playARecording.js. The `to` number is any phone number you wish to call. This number must be verified. `from` is a persephony number that makes the call ([Incoming Numbers](https://www.persephony.com/dashboard/portal/numbers)). `recordingUrl` is a url where persephony can download a recording to play. The recording must be [formatted correclty](https://docs.persephony.com/reference/interactive-voice-response-ivr#play) to work with persephony. Recordings made by persephony during other calls can be played by using the url provided in the [recordings page](https://www.persephony.com/dashboard/portal/recordings).

## Building and Runnning the Tutorial

1. Build and run the application using command:

   ```bash
   $ gradle build && java -Dserver.port=3000 -jar build/libs/gs-spring-boot-0.1.0.jar
   ```

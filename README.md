# Java - Play a Recording Tutorial

This project serves as a guide to help you build an application with FreeClimb. View this tutorial on [FreeClimb.com](https://docs.freeclimb.com/docs/play-a-recording#section-java). Specifically, the project will:

- Make a call
- Play a recording to a caller during a call.

## Setting up your new app within your FreeClimb account

To get started using a FreeClimb account, follow the instructions [here](https://docs.freeclimb.com/docs/getting-started-with-freeclimb).

## Setting up the Tutorial

1. Configure environment variables.

   | ENV VARIABLE            | DESCRIPTION                                                                                                                                                                        |
   | ----------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
   | ACCOUNT_ID              | Account ID which can be found under [API credentials](https://www.freeclimb.com/dashboard/portal/account/authentication) in Dashboard                                                     |
   | API_KEY              | API key which can be found under [API credentials](https://www.freeclimb.com/dashboard/portal/account/authentication) in Dashboard                                           |
   | TUTORIAL_APPLICATION_ID | Appliction IDs can be found under [Apps](https://www.freeclimb.com/dashboard/portal/applications)                                                                                  |
   | TO_PHONE_NUMBER         | The phone number which is being called. [Must be a verified phone number](https://docs.freeclimb.com/docs/using-your-trial-account#section-verifying-outbound-numbers) (for trial users) and in E.164 format.            |
   | FREE_CLIMB_PHONE_NUMBER | The FreeClimb number that is being used to make a phone call. To learn more go [here](https://docs.freeclimb.com/docs/getting-started-with-freeclimb#section-2-get-a-phone-number) |

2. Provide a value for the variable `recordingUrl` in PlayARecording.java. `recordingUrl` is a url where FreeClimb can download a recording to play. The recording must be [formatted correctly](https://docs.freeclimb.com/reference/interactive-voice-response-ivr#play) to work with FreeClimb. Recordings made by FreeClimb during other calls can be played by using a url of the form `/Accounts/{account_id}/Recordings/{recording_id}`. Recording ids are provided in the [recordings page](https://www.freeclimb.com/dashboard/portal/recordings).

## Building and Runnning the Tutorial

1. Build and run the application using command:

   ```bash
   $ gradle build && java -Dserver.port=3000 -jar build/libs/gs-spring-boot-0.1.0.jar
   ```


## Getting Help

If you are experiencing difficulties, [contact support](https://freeclimb.com/support).

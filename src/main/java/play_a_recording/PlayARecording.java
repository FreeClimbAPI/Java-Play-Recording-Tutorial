package main.java.play_a_recording;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vailsys.persephony.api.PersyClient;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.call.Call;
import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.percl.PerCLScript;
import com.vailsys.persephony.webhooks.call.VoiceCallback;
import com.vailsys.persephony.percl.Play;

@RestController
public class PlayARecording {
  private static final String fromNumber = System.getenv("PERSEPHONY_PHONE_NUMBER");
  private final String recordingUrl = "/Accounts/AC272d8570e9ae7cf7090da7cb5a5f45b48f786487/Recordings/REb0432826bc5ffb5af0da83cf697b7dc6e38911b3";

  public static void run() {
    String accountId = System.getenv("ACCOUNT_ID");
    String authToken = System.getenv("AUTH_TOKEN");
    String applicationId = System.getenv("TUTORIAL_APPLICATION_ID");
    String toNumber = System.getenv("TO_PHONE_NUMBER");

    outDial(accountId, authToken, toNumber, applicationId);
  }

  public static void outDial(String accountId, String authToken, String toNumber, String applicationId) {
    try {
      // Create PersyClient object
      PersyClient client = new PersyClient(accountId, authToken);

      Call call = client.calls.create(toNumber, fromNumber, applicationId);
    } catch (PersyException ex) {
      // Exception throw upon failure
    }
  }

  @RequestMapping(value = {
      "/InboundCall" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String inboundCall(@RequestBody String body) {
    VoiceCallback callStatusCallback;
    // Create an empty PerCL script container
    PerCLScript script = new PerCLScript();
    try {
      // Convert JSON into call status call back object
      callStatusCallback = VoiceCallback.createFromJson(body);
    } catch (PersyException pe) {
      // Do something with the failure to parse the request
      return script.toJson();
    }

    // Verify call is in the InProgress state
    if (callStatusCallback.getDialCallStatus() == CallStatus.IN_PROGRESS) {
      // Create PerCL play script with US English as the language
      Play play = new Play(recordingUrl);

      // Add PerCL play script to PerCL container
      script.add(play);
    }
    return script.toJson();
  }
}
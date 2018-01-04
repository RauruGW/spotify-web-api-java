package com.wrapper.spotify.requests.data.tracks;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AudioFeatures;
import com.wrapper.spotify.requests.data.AbstractDataRequest;

import java.io.IOException;

public class GetAudioFeaturesForSeveralTracksRequest extends AbstractDataRequest {

  private GetAudioFeaturesForSeveralTracksRequest(final Builder builder) {
    super(builder);
  }

  public AudioFeatures[] execute() throws
          IOException,
          SpotifyWebApiException {
    return new AudioFeatures.JsonUtil().createModelObjectArray(getJson(), "audio_features");
  }

  public static final class Builder extends AbstractDataRequest.Builder<Builder> {

    public Builder(final String accessToken) {
      super(accessToken);
    }

    public Builder ids(final String ids) {
      assert (ids != null);
      assert (ids.split(",").length <= 100);
      return setQueryParameter("ids", ids);
    }

    @Override
    public GetAudioFeaturesForSeveralTracksRequest build() {
      setPath("/v1/audio-features");
      return new GetAudioFeaturesForSeveralTracksRequest(this);
    }
  }
}

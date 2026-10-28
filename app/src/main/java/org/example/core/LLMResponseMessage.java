package org.example.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A single streamed chat-completion chunk, without the SSE data prefix. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LLMResponseMessage(
    List<Choice> choices,
    long created,
    String id,
    String model,
    @JsonProperty("system_fingerprint") String systemFingerprint,
    String object) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Choice(
      @JsonProperty("finish_reason") String finishReason,
      int index,
      Delta delta) {
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public record Delta(
      String role,
      String content,
      @JsonProperty("reasoning_content") String reasoningContent) {
  }
}

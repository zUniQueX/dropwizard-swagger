/*
 * Copyright © 2014 Federico Recio (N/A)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Copyright (C) 2014 Federico Recio
/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.federecio.dropwizard.swagger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Maps;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

/** For the meaning of all these properties please refer to Swagger UI documentation */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwaggerOAuth2Configuration implements Cloneable {

  @Nullable private String clientId;

  @Nullable private String clientSecret;

  @Nullable private String realm;

  @Nullable private String appName;

  @Nullable private String scopeSeparator;

  private Map<String, String> additionalQueryStringParams = Maps.newHashMap();

  @Nullable
  public String getClientId() {
    return clientId;
  }

  public void setClientId(@Nullable String clientId) {
    this.clientId = clientId;
  }

  @Nullable
  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(@Nullable String clientSecret) {
    this.clientSecret = clientSecret;
  }

  @Nullable
  public String getRealm() {
    return realm;
  }

  public void setRealm(@Nullable String realm) {
    this.realm = realm;
  }

  @Nullable
  public String getAppName() {
    return appName;
  }

  public void setAppName(@Nullable String appName) {
    this.appName = appName;
  }

  @Nullable
  public String getScopeSeparator() {
    return scopeSeparator;
  }

  public void setScopeSeparator(@Nullable String scopeSeparator) {
    this.scopeSeparator = scopeSeparator;
  }

  public Map<String, String> getAdditionalQueryStringParams() {
    return Maps.newHashMap(additionalQueryStringParams);
  }

  public void setAdditionalQueryStringParams(Map<String, String> additionalQueryStringParams) {
    this.additionalQueryStringParams = Maps.newHashMap(additionalQueryStringParams);
  }

  @Override
  public SwaggerOAuth2Configuration clone() {
    try {
      SwaggerOAuth2Configuration clone = (SwaggerOAuth2Configuration) super.clone();
      clone.setAdditionalQueryStringParams(this.additionalQueryStringParams);
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}

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

import static io.federecio.dropwizard.swagger.SwaggerResource.PATH;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(PATH)
@Produces(MediaType.TEXT_HTML)
public class SwaggerResource {
  static final String PATH = "/swagger";
  private final SwaggerViewConfiguration viewConfiguration;
  private final SwaggerOAuth2Configuration oAuth2Configuration;
  private final String contextRoot;
  private final String urlPattern;
  private final String customJavascriptPath;

  public SwaggerResource(
      String urlPattern,
      final SwaggerViewConfiguration viewConfiguration,
      final SwaggerOAuth2Configuration oAuth2Configuration) {
    this.urlPattern = urlPattern;
    this.viewConfiguration = viewConfiguration.clone();
    this.oAuth2Configuration = oAuth2Configuration.clone();
    this.contextRoot = "/";
    this.customJavascriptPath = null;
  }

  public SwaggerResource(
      String urlPattern,
      final SwaggerViewConfiguration viewConfiguration,
      final SwaggerOAuth2Configuration oAuth2Configuration,
      String contextRoot) {
    this.viewConfiguration = viewConfiguration.clone();
    this.oAuth2Configuration = oAuth2Configuration.clone();
    this.urlPattern = urlPattern;
    this.contextRoot = contextRoot;
    this.customJavascriptPath = null;
  }

  public SwaggerResource(
      String urlPattern,
      final SwaggerViewConfiguration viewConfiguration,
      final SwaggerOAuth2Configuration oAuth2Configuration,
      String contextRoot,
      String customJavascriptPath) {
    this.viewConfiguration = viewConfiguration.clone();
    this.oAuth2Configuration = oAuth2Configuration.clone();
    this.urlPattern = urlPattern;
    this.contextRoot = contextRoot;
    this.customJavascriptPath = customJavascriptPath;
  }

  @GET
  public SwaggerView get() {
    return new SwaggerView(
        contextRoot, urlPattern, viewConfiguration, oAuth2Configuration, customJavascriptPath);
  }
}

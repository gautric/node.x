/*
 * Copyright 2011 VMware, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nodex.java.examples.http;

import org.nodex.java.core.Handler;
import org.nodex.java.core.NodexMain;
import org.nodex.java.core.buffer.Buffer;
import org.nodex.java.core.http.HttpClient;
import org.nodex.java.core.http.HttpClientResponse;

/**
 * User: tim
 * Date: 12/08/11
 * Time: 11:44
 */
public class ClientExample extends NodexMain {
  public static void main(String[] args) throws Exception {
    new ClientExample().run();

    System.out.println("Hit enter to exit");
    System.in.read();
  }

  public void go() throws Exception {
    new HttpClient().setPort(8080).setHost("localhost").getNow("/", new Handler<HttpClientResponse>() {
      public void handle(HttpClientResponse response) {
        response.dataHandler(new Handler<Buffer>() {
          public void handle(Buffer data) {
            System.out.println(data);
          }
        });
      }
    });
  }
}

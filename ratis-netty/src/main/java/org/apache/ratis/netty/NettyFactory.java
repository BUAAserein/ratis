/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ratis.netty;

import org.apache.ratis.client.ClientFactory;
import org.apache.ratis.netty.client.NettyClientRpc;
import org.apache.ratis.netty.server.NettyRpcService;
import org.apache.ratis.rpc.SupportedRpcType;
import org.apache.ratis.server.impl.RaftServerImpl;
import org.apache.ratis.server.impl.ServerFactory;

public class NettyFactory extends ServerFactory.BaseFactory implements ClientFactory {
  @Override
  public SupportedRpcType getRpcType() {
    return SupportedRpcType.NETTY;
  }

  @Override
  public NettyRpcService newRaftServerRpc(RaftServerImpl server) {
    return NettyRpcService.newBuilder().setServer(server).build();
  }

  @Override
  public NettyClientRpc newRaftClientRpc() {
    return new NettyClientRpc();
  }
}
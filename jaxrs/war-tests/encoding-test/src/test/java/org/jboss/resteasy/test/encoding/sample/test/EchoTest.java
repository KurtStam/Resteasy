package org.jboss.resteasy.test.encoding.sample.test;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.test.encoding.sample.HelloClient;
import org.junit.Assert;
import org.junit.Test;

/**
 * RESTEASY-208, RESTEASY-214
 */
public class EchoTest
{

   private static final String SPACES_REQUEST = "something something";
   private static final String QUERY = "select p from VirtualMachineEntity p where guest.guestId = :id";

   @Test
   public void testEcho()
   {
      RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
      HelloClient client = ProxyFactory.create(HelloClient.class, "http://localhost:9095");
      Assert.assertEquals(SPACES_REQUEST, client.sayHi(SPACES_REQUEST));

      Assert.assertEquals(QUERY, client.compile(QUERY));
   }
}

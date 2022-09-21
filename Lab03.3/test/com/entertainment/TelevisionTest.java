package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private final Television tv = new Television("LG", 25, DisplayType.LED);

  @Before
  public void setUp() {
  }
  @Test
  public void testSetVolume() {
    tv.setVolume(22);
    assertEquals(22, tv.getVolume());
  }

  @Test
  public void testSetVolumeIllegalArgumentsException(){
    try {
      tv.setVolume(150);

      fail("Should have thrown IllegalArgumentException");
    }
     catch (IllegalArgumentException e){
      assertEquals("Invalid volume: 150. Allowed range: [0,100].", e.getMessage());
    }
  }

  @Test
  public void testChangeChannel() throws InvalidChannelException {
    tv.changeChannel(500); //range is 1-999
    assertEquals(500, tv.getCurrentChannel());
  }

  @Test
  public void testChangeChannelIllegalArgumentsException() {
    try {
      tv.changeChannel(-10);

      fail("Should have thrown IllegalArgumentException");
    } catch (InvalidChannelException e) {

    }
    catch(IllegalArgumentException e){
      assertEquals("Invalid channel: -10. Allowed range: [1,999].", e.getMessage());
    }
  }

  @Test
  public void testCompareTo() {
    Television tv2 = new Television("Sony");
    assertTrue(tv.compareTo(tv2) < 0);
  }

  @Test
  public void testHashCode() {
    Television tv2 = new Television("LG", 25, DisplayType.LED);
    assertEquals(tv.hashCode(), tv2.hashCode());
    Television tv3 = new Television("LG", 45, DisplayType.LED);
    assertNotEquals(tv.hashCode(), tv3.hashCode());
  }

  @Test
  public void testEquals() {
    Television tv2 = new Television("LG", 25, DisplayType.LED);
    assertEquals(tv, tv2);
    Television tv3 = new Television("LG", 45, DisplayType.LED);
    assertNotEquals(tv,tv3);
  }
}
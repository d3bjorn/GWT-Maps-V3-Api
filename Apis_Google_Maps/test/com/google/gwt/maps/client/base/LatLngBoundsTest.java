package com.google.gwt.maps.client.base;

import com.google.gwt.maps.client.AbstractMapsGWTTest;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;

public class LatLngBoundsTest extends AbstractMapsGWTTest {

	@Override
	public LoadLibrary[] getLibraries() {
		return null;
	}

	public void testContains() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				LatLng ll = LatLng.newInstance(-30d, 126d);
				boolean right = llb.contains(ll);
				assertEquals(true, right);
				finishTest();
			}
		});
	}

	public void testEquals() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw1 = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne1 = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb1 = LatLngBounds.newInstance(sw1, ne1);
				LatLng sw2 = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne2 = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb2 = LatLngBounds.newInstance(sw2, ne2);
				boolean right = llb1.equals(llb2);
				assertEquals(true, right);
				finishTest();
			}
		});
	}

	public void testExtend() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				LatLng point = LatLng.newInstance(-24d, 132d);
				LatLngBounds llb2 = llb.extend(point);
				assertEquals("((-31.203405, 125.24414100000001), (-24, 132))",
						llb2.toString());
				finishTest();
			}
		});
	}

	public void testGetNESW() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				LatLng llsw = llb.getSouthWest();
				LatLng llne = llb.getNorthEast();
				assertEquals("(-31.203405, 125.24414100000001)",
						llsw.toString());
				assertEquals("(-25.363882, 131.04492200000004)",
						llne.toString());
				finishTest();
			}
		});
	}

	public void testGetToString() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				assertEquals(
						"((-31.203405, 125.24414100000001), (-25.363882, 131.04492200000004))",
						llb.getToString());
				finishTest();
			}
		});
	}

	public void testIntersects() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw1 = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne1 = LatLng.newInstance(-25.3633882d, 131.0434922d);
				LatLngBounds llb1 = LatLngBounds.newInstance(sw1, ne1);
				LatLng sw2 = LatLng.newInstance(-32.203405d, 126.244141d);
				LatLng ne2 = LatLng.newInstance(-26.363882d, 132.044922d);
				LatLngBounds llb2 = LatLngBounds.newInstance(sw2, ne2);
				boolean llb3 = llb1.intersects(llb2);
				assertEquals(true, llb3);
				finishTest();
			}
		});
	}

	public void testIsEmpty() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				boolean empty = llb.isEmpty();
				assertEquals(false, empty);
				finishTest();
			}
		});
	}

	public void testNotEquals() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw1 = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne1 = LatLng.newInstance(-25.3633882d, 131.0434922d);
				LatLngBounds llb1 = LatLngBounds.newInstance(sw1, ne1);
				LatLng sw2 = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne2 = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb2 = LatLngBounds.newInstance(sw2, ne2);
				boolean right = llb1.equals(llb2);
				assertEquals(false, right);
				finishTest();
			}
		});
	}

	public void testToSpan() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				LatLng ll = llb.toSpan();
				assertEquals("(5.839523, 5.800781000000029)", ll.toString());
				finishTest();
			}
		});
	}

	public void testToUrlValue() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds llb = LatLngBounds.newInstance(sw, ne);
				String ll = llb.toUrlValue(7);
				assertEquals("-31.203405,125.244141,-25.363882,131.044922", ll);
				finishTest();
			}
		});
	}

	public void testUnion() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw1 = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne1 = LatLng.newInstance(-25.3633882d, 131.0434922d);
				LatLngBounds llb1 = LatLngBounds.newInstance(sw1, ne1);
				LatLng sw2 = LatLng.newInstance(-32.203405d, 126.244141d);
				LatLng ne2 = LatLng.newInstance(-27d, 133.044922d);
				LatLngBounds llb2 = LatLngBounds.newInstance(sw2, ne2);
				LatLngBounds llb3 = llb1.union(llb2);
				assertEquals(
						"((-32.203405, 125.24414100000001), (-25.3633882, 133.04492200000004))",
						llb3.toString());
				finishTest();
			}
		});
	}

	/**
	 * See <a href=
	 * "https://developers.google.com/maps/documentation/javascript/events"
	 * >Events API Doc</a>
	 */
	@SuppressWarnings("unused")
	public void testUse() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405d, 125.244141d);
				LatLng ne = LatLng.newInstance(-25.363882d, 131.044922d);
				LatLngBounds left = LatLngBounds.newInstance(sw, ne);
				finishTest();
			}
		});
	}

	public void testUse2() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng sw = LatLng.newInstance(-31.203405, 125.244141);
				LatLng ne = LatLng.newInstance(-25.363882, 131.044922);
				LatLngBounds left = LatLngBounds.newInstance(sw, ne);
				assertEquals(
						"((-31.203405, 125.24414100000001), (-25.363882, 131.04492200000004))",
						left.getToString());
				finishTest();
			}
		});
	}

}

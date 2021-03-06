package com.google.gwt.maps.client.streetview;

import com.google.gwt.maps.client.AbstractMapsGWTTest;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.controls.ControlPosition;
import com.google.gwt.maps.client.controls.PanControlOptions;

public class StreetViewPanaoramaOptionsTest extends AbstractMapsGWTTest {

	@Override
	public LoadLibrary[] getLibraries() {
		return null;
	}

	@SuppressWarnings("unused")
	public void testUse() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				finishTest();
			}
		});

	}

	public void testAddressControl() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				boolean left = true;
				options.setAddressControl(left);
				boolean right = options.getAddressControl();
				assertEquals(left, right);
				finishTest();
			}
		});

	}

	public void testAddressControlOptions() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				StreetViewAddressControlOptions left = StreetViewAddressControlOptions
						.newInstance();
				left.setPosition(ControlPosition.BOTTOM_CENTER);
				options.setAddressControlOptions(left);
				StreetViewAddressControlOptions right = options
						.getAddressControlOptions();
				assertEquals(left.getPosition(), right.getPosition());
				finishTest();
			}
		});

	}

	public void testDisableDoubleClickZoom() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				boolean left = true;
				options.setDisableDoubleClickZoom(left);
				boolean right = options.getDisableDoubleClickZoom();
				assertEquals(left, right);
				finishTest();
			}
		});

	}

	public void testEnableCloseButton() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				boolean left = true;
				options.setEnableCloseButton(left);
				boolean right = options.getEnableCloseButton();
				assertEquals(left, right);
				finishTest();
			}
		});

	}

	public void testLinksControl() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				boolean left = true;
				options.setLinksControl(left);
				boolean right = options.getLinksControl();
				assertEquals(left, right);
				finishTest();
			}
		});

	}

	public void testPanControl() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				boolean left = true;
				options.setPanControl(left);
				boolean right = options.getPanControl();
				assertEquals(left, right);
				finishTest();
			}
		});

	}

	public void testPanControlOptions() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				PanControlOptions left = PanControlOptions.newInstance();
				left.setPosition(ControlPosition.BOTTOM_CENTER);
				options.setPanControlOptions(left);
				PanControlOptions right = options.getPanControlOptions();
				assertEquals(left.getPosition(), right.getPosition());
				finishTest();
			}
		});

	}

	public void testPano() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				String left = "test";
				options.setPano(left);
				String right = options.getPano();
				assertEquals(left, right);
				finishTest();
			}
		});

	}

	/**
	 * TODO finish in render
	 */
	public void testPanoProvider() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				StreetViewPanoramaOptions options = StreetViewPanoramaOptions
						.newInstance();
				options.setPanoProvider(new StreetViewPanoramaProvider() {
					@Override
					public StreetViewPanoramaData getPanoData(String pano,
							int zoom, int tileX, int tileY) {
						// TODO
						return null;
					}
				});
				// TODO assert something
				finishTest();
			}
		});

	}

}

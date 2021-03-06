package com.google.gwt.maps.client;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.base.LatLng;

/**
 * Common actions taken when testing maps code
 * 
 * @author Joseph Lust
 * 
 */
public abstract class AbstractMapsGWTTest extends GWTTestCase {

	private final String MODULE_NAME = "com.google.gwt.maps.Apis_Google_Maps_ForTests";
	private int asyncDelayMs = 5000;
	private final double equalsEpsilon = 1e-3;
	private boolean sensor = false;

	/**
	 * Runs the test with libraries defined by the {@link #getLibraries()}
	 * override loaded and fails if not complete by {@link #getAsyncDelayMs()}.<br>
	 * <br>
	 * <b>NOTE:</b> You must call {@link #finishTest()} or test will fail.
	 * 
	 * @param test
	 *            code to run
	 */
	public final void asyncLibTest(Runnable test) {
		// handle the nulls
		LoadLibrary[] libs = getLibraries();
		if (libs == null) {
			libs = new LoadLibrary[] {};
		}
		asyncLibTest(test, libs);
	}

	/**
	 * Runs the test with the given libraries loaded and fails if not complete
	 * by {@link #getAsyncDelayMs()}.<br>
	 * <br>
	 * <b>NOTE:</b> You must call {@link #finishTest()} or test will fail.
	 * 
	 * @param test
	 *            code to run
	 * @param libs
	 *            libraries to have loaded
	 */
	public final void asyncLibTest(Runnable test, LoadLibrary... libs) {
		// pack
		ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadLibrary>();
		loadLibraries.addAll(Arrays.asList(libs));

		// run
		LoadApi.go(test, loadLibraries, isSensor());

		// ensure expiration is does not reach finishTest()
		delayTest();
	}

	public final void delayTest() {
		delayTestFinish(getAsyncDelayMs());
	}

	/**
	 * Get delay to wait until failing the test as incomplete
	 * 
	 * @return
	 */
	public final int getAsyncDelayMs() {
		return asyncDelayMs;
	}

	/**
	 * Returns the libraries that will be loaded before the test is run if the
	 * no library method overload is called.
	 * 
	 * @return
	 */
	public abstract LoadLibrary[] getLibraries();

	@Override
	public String getModuleName() {
		return MODULE_NAME;
	}

	/**
	 * Is the test with run as with a device sensor
	 * 
	 * @return
	 */
	public final boolean isSensor() {
		return sensor;
	}

	public final void setAsyncDelayMs(int asyncDelayMs) {
		this.asyncDelayMs = asyncDelayMs;
	}

	public final void setSensor(boolean sensor) {
		this.sensor = sensor;
	}

	public final double getEqualsEpsilon() {
		return equalsEpsilon;
	}

	/** HELPERS **/

	/**
	 * Assert that two {@link LatLng} are equal within
	 * {@link #getEqualsEpsilon()}.
	 * 
	 * @param point1
	 * @param point2
	 */
	public final void assertLatLngEquals(LatLng point1, LatLng point2) {
		assert point1 != null : "Point1 cannot be null in assertLatLngEquals()";
		assert point2 != null : "Point2 cannot be null in assertLatLngEquals()";

		assertEquals("Latitude not equal within epsilon", point1.getLatitude(),
				point2.getLatitude(), getEqualsEpsilon());
		assertEquals("Longitude not equal within epsilon",
				point1.getLongitude(), point2.getLongitude(),
				getEqualsEpsilon());
	}

}

package io.reflectoring.raito4rpi.core.led;

/**
 * Represents an actual RGB-LED.
 */
public class RgbLed {

	private int redPinAddress;
	private int greenPinAddress;
	private int bluePinAddress;

	/**
	 * Creates an instance of an RGB-LED which is connected via the given Pins.
	 *
	 * @param redPinAddress
	 *            the pin which connects to the red leg
	 * @param greenPinAddress
	 *            the pin which connects to the green leg
	 * @param bluePinAddress
	 *            the pin which connects to the blue leg
	 */
	public RgbLed(int redPinAddress, int greenPinAddress, int bluePinAddress) {
		this.redPinAddress = redPinAddress;
		this.greenPinAddress = greenPinAddress;
		this.bluePinAddress = bluePinAddress;
	}

	public int getRedPinAddress() {
		return redPinAddress;
	}

	public void setRedPinAddress(int redPinAddress) {
		this.redPinAddress = redPinAddress;
	}

	public int getGreenPinAddress() {
		return greenPinAddress;
	}

	public void setGreenPinAddress(int greenPinAddress) {
		this.greenPinAddress = greenPinAddress;
	}

	public int getBluePinAddress() {
		return bluePinAddress;
	}

	public void setBluePinAddress(int bluePinAddress) {
		this.bluePinAddress = bluePinAddress;
	}
}

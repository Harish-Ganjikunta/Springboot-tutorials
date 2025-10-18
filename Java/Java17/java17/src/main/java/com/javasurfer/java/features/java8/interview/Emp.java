package com.javasurfer.java.features.java8.interview;

import java.util.ArrayList;
import java.util.List;

public final class Emp {

        private final int employeeId;
        private final String name;
        private final Address address; // An immutable nested object
        private final List<String> hobbies; // A mutable object reference

        public Emp(int employeeId, String name, Address address, List<String> hobbies) {
            this.employeeId = employeeId;
            this.name = name;
            // Defensive copy for mutable nested objects
            this.address = new Address(address.getStreet(), address.getCity());
            this.hobbies = new ArrayList<>(hobbies); // Defensive copy for mutable lists
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            // Return a defensive copy of the mutable nested object
            return new Address(this.address.getStreet(), this.address.getCity());
        }

        public List<String> getHobbies() {
            // Return a defensive copy of the mutable list
            return new ArrayList<>(this.hobbies);
        }

        @Override
        public String toString() {
            return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + ", hobbies=" + hobbies + "]";
        }
}

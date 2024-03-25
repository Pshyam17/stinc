package com.example.stinc;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBconnect {
    public String name;
    public String email;

    public DBconnect() {
    }

    public DBconnect(String name, String email) {
        this.name = name;
        this.email = email;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersRef = database.getReference("users");
    DBconnect newUser = new DBconnect("John Doe", "johndoe@example.com");
    String userId = usersRef.push().getKey();
    usersRef.child(userId).

    void setValue(newUser)
        .

    addOnCompleteListener(task ->

    {
        if (task.isSuccessful()) {
            // Data is successfully written
        } else {
            // Write failed
        }
    });

    DatabaseReference userRef = usersRef.child(userId);
        userRef.addValueEventListener(new

    ValueEventListener() {
        @Override
        public void onDataChange (@NonNull DataSnapshot dataSnapshot){
            User user = dataSnapshot.getValue(User.class);
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            String name = user.name;
            String email = user.email;
            // Update UI or perform other actions
        }

        @Override
        public void onCancelled (@NonNull DatabaseError error){
            // Failed to read value
        }
    });
}
## Coding test

At `https://live-test-scores.herokuapp.com/scores` you'll find a service that follows the [Server-Sent Events](https://html.spec.whatwg.org/multipage/server-sent-events.html#server-sent-events) protocol. You can connect to the service using cURL:

        curl https://live-test-scores.herokuapp.com/scores

Periodically, you'll receive a JSON payload that represents a student's test score (a JavaScript number between 0 and 1), the exam number, and a student ID that uniquely identifies a student. For example:

        event: score
        data: {"exam": 3, "studentId": "foo", score: .991}

This represents that student foo received a score of `.991` on exam #3. 

Your job is to build a mobile app that consumes this data, processes it, and provides a simple user interface that exposes the processed results. 

You may build this app for either Android (written in Java) or iOS (written in Swift); we will use this project as part of your onsite interviews, so pick a language and tech stack with which you would be comfortable in a live coding session. You may use any open-source libraries or resources that you find helpful. **As part of the exercise, please replace this README file with instructions for building and running your project.** We will run your code as part of our review process.

Here are the operations we would want your mobile app to support:

1. An operation to list all the users that have received at least one exam score.
2. An operation to list all the exam results for a specified student ID.
3. An operation to list all the exams that have been recorded.
4. An operation to list all the results for a specified exam.

Coding tests are often contrived, and this exercise is no exception. To the best of your ability, make your solution reflect the kind of code you'd want shipped within a production build. A few things we're specifically looking for:

* Well-structured, well-written, idiomatic, safe, performant code.
* Tests, reflecting the level of testing you'd expect in a production build.
* Ecosystem understanding. Your code should demonstrate that you understand whatever ecosystem you're coding against— including project layout and organization, use of third party libraries, and build tools.
* Thoughtful intention behind the user interface and data output.

That said, we'd like you to cut some corners so we can focus on certain aspects of the problem:

* Store the results in memory instead of a persistent store. There's no need to persist results across app executions.
* Build a rudimentary user interface. Your user interface should be minimally sufficient to allow for the operations described above and does not need to be "pretty".

The spec is intentionally a little underspecified. We're looking for a functional mobile app that meets the criteria above, but there are no "gotchas," and there is no single "right" solution. Please use your best judgment and be prepared to explain your decisions in the on-site review.

That's it. Commit your solution to the provided GitHub repository (this one) and submit the solution using the Greenhouse link we emailed you. When you come in, we'll pair with you and walk through your solution and extend it in an interesting way.


##Instructions to install
* Simply clone the repository
* Import it in Android Studio
* Build the project in Emulator or Physical Device
* Launch and test the project
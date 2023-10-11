# Post Office Management

We have a post office with:

- 4 counters for customer service
- A small room with input-defined dimensions
- A large room with unlimited dimensions

Customers arrive at the post office randomly and queue up to be served.
The counters are implemented using a ThreadPoolExecutor with 4 threads. Each counter accepts a customer and serves them for a random time between 1 and 120 ms, then waits for the next customer.
If a counter does not serve any customers for 2 seconds, it exits the post office.

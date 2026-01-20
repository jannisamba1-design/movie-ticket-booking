Booking Service – API Contracts

Create Booking (WRITE FLOW)
Endpoint
POST /bookings
Headers
Authorization: Bearer <JWT>
Idempotency-Key: <UUID>
Request Body
{
  "showId": "uuid",
  "seatNumbers": ["A1", "A2"]
}

Response (201 CREATED)
{
  "bookingId": "uuid",
  "status": "CONFIRMED",
  "totalAmount": 450
}

Failure Scenarios
Condition	HTTP Code
Seats already locked	409 Conflict
Duplicate request	200 OK (idempotent)
Inventory timeout	503 Service Unavailable

Get Booking Details (READ – Optional)
Endpoint
GET /bookings/{bookingId}
Response
{
  "bookingId": "uuid",
  "showId": "uuid",
  "status": "CONFIRMED",
  "seats": ["A1", "A2"]
}

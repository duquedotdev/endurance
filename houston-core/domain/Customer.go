package domain

import (
	"github.com/google/uuid"
	"time"
)

type Customer struct {
	id        string
	createdAt time.Time
	updatedAt time.Time
	deletedAt time.Time
}

func NewCustomer() *Customer {
	c := &Customer{}
	c.id = uuid.NewString()
	c.createdAt = time.Now().UTC()
	c.updatedAt = time.Now().UTC()
	return c
}

package domain

import (
	"github.com/google/uuid"
	"time"
)

type Machine struct {
	id         string
	customerId string
	isActive   bool
	createdAt  time.Time
	updatedAt  time.Time
	deletedAt  time.Time
}

func newMachine() *Machine {
	m := &Machine{}
	m.id = uuid.NewString()
	m.isActive = true
	m.createdAt = time.Now().UTC()
	m.updatedAt = time.Now().UTC()
	return m
}

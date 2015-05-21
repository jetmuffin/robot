package com.dag.robot.neo.type;

import org.neo4j.graphdb.Label;

public enum LabelTypes implements Label {
	Field,
	Topic,
	Expert,
	Paper,
	Patent,
	Organization,
	KNOWLAGE
}

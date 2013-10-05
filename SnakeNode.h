///////////////////////////////////////////////////////////
//  SnakeNode.h
//  Implementation of the Class SnakeNode
//  Created on:      05-Ê®ÔÂ-2013 11:16:09
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_0DD391CF_45E4_466c_B290_FAA7F482D5BC__INCLUDED_)
#define EA_0DD391CF_45E4_466c_B290_FAA7F482D5BC__INCLUDED_

#include "SnakeDisplayAdapter.h"

class SnakeNode
{

public:
	SnakeNode();
	virtual ~SnakeNode();
	int m_col;
	int m_row;
	SnakeDisplayAdapter *m_SnakeDisplayAdapter;

};
#endif // !defined(EA_0DD391CF_45E4_466c_B290_FAA7F482D5BC__INCLUDED_)

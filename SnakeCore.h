///////////////////////////////////////////////////////////
//  SnakeCore.h
//  Implementation of the Class SnakeCore
//  Created on:      05-Ê®ÔÂ-2013 18:14:18
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_618919C1_2783_4492_8804_B37217CCE0C0__INCLUDED_)
#define EA_618919C1_2783_4492_8804_B37217CCE0C0__INCLUDED_

#include "SnakeNode.h"
#include "SnakeDisplayAdapter.h"
#include "ConfigFileExtractor.h"
#include "SnakeControlAdapter.h"
#include "SnakeState.h"

class SnakeCore
{

public:
	SnakeCore();
	virtual ~SnakeCore();
	SnakeDisplayAdapter *m_SnakeDisplayAdapter;
	ConfigFileExtractor *m_ConfigFileExtractor;
	SnakeControlAdapter *m_SnakeControlAdapter;
	SnakeState *m_SnakeState;

	void GameInit();
	void SetDirection(const char dir);
	bool MoveSnake(const char dir);
	void GameCircle();
	void GameOver();

private:
	SnakeControlAdapter& m_ctrlAdapter;
	SnakeDisplayAdapter& m_dispAdapter;
	char m_dir;
	SnakeState* m_state;
	SnakeNode m_nodesvector;
	bool m_isPause;
	SnakeNode m_nodesvector;
	SnakeNode m_nodesvector;
	SnakeNode m_nodesvector;

};
#endif // !defined(EA_618919C1_2783_4492_8804_B37217CCE0C0__INCLUDED_)
